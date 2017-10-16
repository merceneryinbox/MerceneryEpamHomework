package homework.epam.mod1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JSE01Task05BlockNoteArray {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * @param args For self test of two classes : BlockNote & EntryNote
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
     * Class BlockNote stores in itself List<String>  where String is - entry of EntryNote class.
     */
    public static class BlockNote {
        private List<EntryNote> storeOfNotes;

        public BlockNote() {
            storeOfNotes = new ArrayList<>();
        }

        /**
         * @param addingEntryNote
         */
        private void addNote(EntryNote addingEntryNote) {
            storeOfNotes.add(addingEntryNote);
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
         * Printing ArrayList with all it's entries.
         */
        public void showAllNotes() {
            for (EntryNote entry : storeOfNotes) {
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