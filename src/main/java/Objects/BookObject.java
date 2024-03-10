package Objects;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
    public class BookObject {
    private String title;
    private String author;
    private MetaData metadata;

    public BookObject(String title, String Author, MetaData metadata)
    {
        this.title=title;
        this.author=Author;
        this.metadata=metadata;
    }

}

