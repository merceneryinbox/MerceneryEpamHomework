CREATE TABLE bookShelf
(
  -- only integer type can be autoincremented, got VARCHAR(24)
  bookName VARCHAR(24) PRIMARY KEY NOT NULL,
  author VARCHAR(24) NOT NULL,
  publisher VARCHAR(24) NOT NULL,
  type VARCHAR(24) NOT NULL,
  yearproductionbook INT NOT NULL
);

INSERT INTO bookShelf(bookName, author, publisher, type, yearproductionbook)
VALUES ('War and Peace','Lev Tolstoy','himself','drama',1867);
