package pl.dm.libraryprojectdm.model;

public enum BookType {
    SCIENCE_FICTION("Science Fiction"),
    HORROR("Horror"),
    ROMANCE("Romance"),
    TRAVEL("Travel"),
    SCIENCE("Science"),
    HISTORY("History"),
    FANTASY("Fantasy");

    private String text;

    BookType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
