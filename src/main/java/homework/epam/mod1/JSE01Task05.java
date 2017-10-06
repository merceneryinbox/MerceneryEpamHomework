//Задание 6. Простейшие классы и объекты
//        Спроектировать и разработать классы Запись в блокноте и Блокнот (записи
//        блокнота хранятся в массиве). Реализовать методы: Добавить запись, Удалить
//        запись, Редактировать запись, Посмотреть все записи. Написать для
//        данного кода javadoc-документацию.

package homework.epam.mod1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Test class for BlockNote and EntryNotes.
 */
public class JSE01Task05 {

    /**
     * @param args For self test of two classes : BlockNote & EntryNote
     *
     * @throws InterruptedException throws by BufferedReader when editing an EntryNote entry
     */
    public static void main(String[] args) throws InterruptedException {
        EntryNote entryNote1 = (new EntryNote("Entry1")).setNotification("Text in entry 1");
        EntryNote entryNote2 = new EntryNote("Entry2");
        entryNote2.setNotification("Text in entry 2");
        EntryNote entryNote3 = new EntryNote("Entry3");
        entryNote3.setNotification("Text in entry 3");
        EntryNote entryNote4 = new EntryNote("Entry4");


        BlockNote blockNote = new BlockNote();

        blockNote.addNote(entryNote1);
        blockNote.addNote(entryNote2);
        blockNote.showAllNotes();

        System.out.println("After delete : \n");
        blockNote.removeNote(entryNote1);
        blockNote.showAllNotes();

        System.out.println();
        blockNote.addNote(entryNote3);
        blockNote.addNote(entryNote4);
        blockNote.showAllNotes();

        System.out.println();
        blockNote.editEntry(entryNote3);
        blockNote.showAllNotes();
    }

    /**
     * Class BlockNote stores in itself Map<EntryNote, String> </EntryNote,> where String is - entry of EntryNote class.
     */
    public static class BlockNote {
        private Map<EntryNote, String> storeOfNotes;

        public BlockNote() {
            storeOfNotes = new HashMap<>();
        }

        /**
         * @param addingEntryNote
         */
        private void addNote(EntryNote addingEntryNote) {
            storeOfNotes.put(addingEntryNote, addingEntryNote.notification);
        }

        /**
         * @param deleteEntryNote
         */
        public void removeNote(EntryNote deleteEntryNote) {
            storeOfNotes.remove(deleteEntryNote);
        }

        /**
         * @param editEntryNote throw new IOException("Error in editing entry " + editEntryNote + " try again, " + e) with my comments
         */
        public void editEntry(EntryNote editEntryNote) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Please edit entry: " + editEntryNote);
                String tmpStr = br.readLine();
                editEntryNote.changeEntryNote(tmpStr);
            } catch (IOException e) {
                try {
                    throw new IOException("Error in editing entry " + editEntryNote + " try again, " + e);
                } catch (IOException ignore) {
                }
            }
        }

        /**
         * Printing Map with all it's entries.
         */
        public void showAllNotes() {
            for (Map.Entry<EntryNote, String> entry : storeOfNotes.entrySet()) {
                System.out.println(entry.toString());
            }
        }
    }

    /**
     * Class EntryNote contains - name (String) and entry (String) + two type of constructors.
     */
    public static class EntryNote {
        private String name = "Default EntryNote name ";
        private String notification = "Default Empty entry";
        private static int count = 1;

        public EntryNote() {
            this.name = name + count;
            count++;
        }

        public EntryNote(String name) {
            setName(name);
            count++;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return " Note in - " + getName() + " - " + getNotification() + " ";
        }

        public String getNotification() {
            return " " + notification + " ";
        }

        public EntryNote setNotification(String notification) {
            this.notification = " " + notification;
            return this;
        }

        public void changeEntryNote(String tmpStr) {
            setNotification("(changed) - " + tmpStr);
        }
    }
}