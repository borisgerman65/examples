package main.java.com.quotient.demofgqlservice.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.quotient.demofgqlservice.types.Show;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ShowsDatafetcher {

    private final List<Show> shows = List.of(

            Show.newBuilder().title("Stranger Things").releaseYear(2016).build(),
            Show.newBuilder().title("Ozark").releaseYear(2017).build(),
            Show.newBuilder().title("The Crown").releaseYear(2016).build(),
            Show.newBuilder().title("Dead to Me").releaseYear(2019).build(),
            Show.newBuilder().title("Orange is the New Black").releaseYear(2013).build()
    );

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
        if(titleFilter == null) {
            return shows;
        }

        return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }
}
