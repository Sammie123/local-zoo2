import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import java.util.Arrays;

public class Stylist {
  private String name;
  private int id;

  public Stylist(String name) {
    this.name = name;
  }

  public String getName() {
      return name;
  }

  public int getId() {
    return id;
  }

  public static List<Stylist> all() {
    String sql = "SELECT id, name FROM stylists";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  public List<Client> getClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM movies WHERE studioId=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Client.class);
    }
  }

  public static Stylist find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE id=:id";
      Stylist studio = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
      return studio;
    }
  }

  @Override
  public boolean equals(Object otherStylist) {
    if (!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName()) && this.getId() == newStylist.getId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name) VALUES (:name);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }
}
