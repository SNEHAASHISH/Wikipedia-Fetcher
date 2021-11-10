package tech.codingclub.Step_14_WikiPediaDownloader;

import tech.codingclub.Step_11_TaskManager.TaskManager;
import tech.codingclub.Step_13_HttpURLConnection.httpURLConnectionExample;

public class WikipediaDownloader implements Runnable {
    private String keyword;

    public WikipediaDownloader() {

    }

    public WikipediaDownloader(String keyword) {
        this.keyword = keyword;
    }

    public void run() {
        //Make a GET request to wikipedia
        //Parsing the useful result using jsoup
        //Showing results !
        if (this.keyword == null || this.keyword.length() == 0) {
            return;
        }
        //Get clean keyword
        this.keyword = this.keyword.trim().replaceAll("[ ] +","_"); // Square brackets are for regex
        //Get the url for wikipedia for query
        String wikiUrl = getWikipediaUrlForQuery(this.keyword);
        try {
            String wikipediaResponse = httpURLConnectionExample.sendGet(wikiUrl);
            System.out.println(wikipediaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getWikipediaUrlForQuery(String cleanKeyword) {
        return "https://en.wikipedia.org/wiki/"+cleanKeyword;
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(20);
        WikipediaDownloader wikipediaDownloader = new WikipediaDownloader("Albert_Einstein");
        taskManager.waitTillQueueIsFreeAndAddTask( wikipediaDownloader );
    }
}
