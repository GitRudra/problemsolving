package org.home.hackerrank;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class MovieStore {

    class MovieStoreResponse{
        String page;
        String per_page;
        String total;
        String total_pages;
        List<Movie> data;

        public MovieStoreResponse(String page, String per_page, String total, String total_pages, List<Movie> data) {
            this.page = page;
            this.per_page = per_page;
            this.total = total;
            this.total_pages = total_pages;
            this.data = data;
        }

        public MovieStoreResponse() {
        }

        public List<Movie> getData() {
            return data;
        }

        public void setData(List<Movie> data) {
            this.data = data;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getPer_page() {
            return per_page;
        }

        public void setPer_page(String per_page) {
            this.per_page = per_page;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(String total_pages) {
            this.total_pages = total_pages;
        }
    }

    class Movie{
        String Title;
        String Year;
        String imdbID;

        public Movie(String title, String year, String imdbID) {
            Title = title;
            Year = year;
            this.imdbID = imdbID;
        }

        public Movie() {
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getYear() {
            return Year;
        }

        public void setYear(String year) {
            Year = year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }
    }

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        int pageNumber = 1;
        List<String> movieList = new ArrayList<>();
        String movieSearchPattern = "spiderman";
        MovieStoreResponse firstResponse = movieStore.makeGetCall(movieSearchPattern,pageNumber);
        int totalPage = Integer.parseInt(firstResponse.getTotal_pages());
        firstResponse.data.forEach(e->movieList.add(e.getTitle()));

        MovieStoreResponse nextResponse;

        for(int i=2;i<=totalPage;i++){
            nextResponse = movieStore.makeGetCall(movieSearchPattern,i);
            nextResponse.data.forEach(e->movieList.add(e.getTitle()));
        }
        Collections.sort(movieList);
        movieList.forEach(System.out::println);
    }

    private static String urlToRead = "https://jsonmock.hackerrank.com/api/movies/search/?Title=substr&page=";

    private MovieStoreResponse makeGetCall(String subStr, int pageNumber){
        StringBuilder result = new StringBuilder();
        HttpURLConnection conn = null;
        BufferedReader rd = null;
        urlToRead = urlToRead.replace("substr",subStr);
        urlToRead = urlToRead+pageNumber;
        Gson jsonConverter = new Gson();
        MovieStoreResponse response = new MovieStoreResponse();
        try {
            URL url = new URL(urlToRead);
//            System.out.println("Opening connection");
            conn = (HttpURLConnection) url.openConnection();
//            System.out.println("Connection opened");
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                response = jsonConverter.fromJson(line,MovieStoreResponse.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(rd!=null){
                try {
                    rd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(conn!=null){
                conn.disconnect();
            }

        }
        return response;

    }
}
