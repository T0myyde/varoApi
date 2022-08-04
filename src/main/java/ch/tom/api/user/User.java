package ch.tom.api.user;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String UUID;

    private String name;


    public User() {}

    public User(String UUID, String name) {
        this.UUID = UUID;
        this.name = name;
    }


    public String getUUID() {
        return UUID;
    }

    public void setUUID(String playerUUID) {
        this.UUID = playerUUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String playerName) {
        this.name = playerName;
    }

    @Override
    public String toString() {
        return "User{" +
                "UUID='" + UUID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
