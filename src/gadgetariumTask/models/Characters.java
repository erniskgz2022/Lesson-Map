package gadgetariumTask.models;

import gadgetariumTask.enums.KeyCharacter;

import java.util.List;
import java.util.Map;

public class Characters {
    private Long id;
    private Map<KeyCharacter, List<String>> characters;

    public Characters() {
    }

    public Characters(Map<KeyCharacter, List<String>> characters) {
        this.characters = characters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<KeyCharacter, List<String>> getCharacters() {
        return characters;
    }

    public void setCharacters(Map<KeyCharacter, List<String>> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "~~~~Characters~~~~" + "\n" +
                "ID: " + id + "\n" +
                "Characters: " + characters ;
    }
}
