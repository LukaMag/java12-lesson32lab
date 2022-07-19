package CLASSWORK32LAB;

import java.util.Objects;

public class Card {
    private String id;
    private String password;

    public Card(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(password, card.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password);
    }

    @Override
    public String toString() {
        return "Card - " +"id=" + id +", password=" + password;
    }
}
