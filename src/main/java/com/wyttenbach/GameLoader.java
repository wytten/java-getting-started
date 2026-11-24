package com.wyttenbach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class GameLoader {
	@Value("${game.definition}")
	private String gameDefinition;

	@Bean
	public Game load() throws IOException {
		Game game = null;
		try (InputStream stream = new ClassPathResource(gameDefinition).getInputStream()) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			game = new Game();
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				if (line.matches("id=[0-9]+")) {
					String parts[] = line.split("=");
					int roomNum = Integer.parseInt(parts[1]);
					String roomDesc = "";
					System.out.println(""+roomNum);
					for (String desc = reader.readLine(); desc != null; desc = reader.readLine()) {
						if (desc.matches("EOD")) {
							System.out.println(""+desc);
							break;
						}
						roomDesc += desc + "<br/>";
					}
					Room room = new Room(roomNum, roomDesc);
					game.addRoom(room);
					for (String actionLine = reader.readLine(); actionLine != null; actionLine = reader.readLine()) {
						if (actionLine.matches("EOR")) {
							System.out.println(""+actionLine);
							break;
						} else if (actionLine.matches("%*[a-z]+ [0-9]+")) {
							parts = actionLine.split(" ");
							int actionNum = Integer.parseInt(parts[1]);
							Action action = new Action(parts[0], actionNum);
							room.addAction(action);
						}

					}
				} else if (line.matches("EOF")) {
					System.out.println(line);
				}
			}
		} 
		
		return game;
	}
}
