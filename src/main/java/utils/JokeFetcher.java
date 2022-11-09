package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ChuckDTO;
import dtos.CombinedJokeDTO;
import dtos.DadDTO;
import java.io.IOException;

public class JokeFetcher {

   public static String TwoJokes() throws IOException {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
      ChuckDTO chuckDTO = gson.fromJson(chuck, ChuckDTO.class);

      String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
      DadDTO dadDTO = gson.fromJson(dad, DadDTO.class);
      CombinedJokeDTO combinedDTO = new CombinedJokeDTO(chuckDTO, dadDTO);

      return gson.toJson(combinedDTO);
   }
}