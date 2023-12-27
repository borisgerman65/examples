package com.quotient.demofgqlservice;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import main.java.com.quotient.demofgqlservice.fetchers.ShowsDatafetcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {DgsAutoConfiguration.class, ShowsDatafetcher.class})
class DemoTests {

  @Autowired DgsQueryExecutor dgsQueryExecutor;

  @Test
  void shows() {
    List<String> titles =
        dgsQueryExecutor.executeAndExtractJsonPath(
            " { shows { title releaseYear }}", "data.shows[*].title");

    assertThat(titles).contains("Ozark");
  }
}
