import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.sql2o.*;

public class StylistTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteClientsQuery = "DELETE FROM clients *;";
      String deleteStylistsQuery = "DELETE FROM stylists *;";
      con.createQuery(deleteClientsQuery).executeUpdate();
      con.createQuery(deleteStylistsQuery).executeUpdate();
    }
  }

  @Test
  public void stylist_instantiatesTrue_true() {
    Stylist testStylist = new Stylist("Lincoln");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_stylistWithName_Lincoln() {
    Stylist testStylist = new Stylist("Lincoln");
    assertEquals("Lincoln", testStylist.getName());
  }

  @Test
  public void all_returnsAllInstances_true() {
    Stylist firstStylist = new Stylist("Lincoln");
    Stylist secondStylist = new Stylist("Molly");
    assertEquals(true, Stylist.all().contains(firstStylist));
    assertEquals(true, Stylist.all().contains(secondStylist));
  }

  @Test
  public void getId_styistGetId_1() {
    Stylist testStylist = new Stylist("Lincoln");
    assertEquals(1, testStylist.getId());
  }

  @Test
  public void find_returnsSameId_secondStylist() {
    Stylist firstStylist = new Stylist("Lincoln");
    Stylist secondStylist = new Stylist("Molly");
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }

  // @Test
  // public void all_returnsAllInstances_true() {
  //   Stylist firstStylist = new Stylist("Lincoln");
  //   firstStylist.save();
  //   Stylist secondStylist = new Stylist("Molly");
  //   secondStylist.save();
  //   assertEquals(true, Stylist.all().get(0).equals(firstStylist));
  //   assertEquals(true, Stylist.all().get(1).equals(secondStylist));
  // }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist firstStylist = new Stylist("Lincoln");
    Stylist secondStylist = new Stylist("Lincoln");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Stylist myStylist = new Stylist("Lincoln");
    myStylist.save();
    assertTrue(Stylist.all().get(0).equals(myStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    Stylist myStylist = new Stylist("Lincolnc");
    myStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(myStylist.getId(), savedStylist.getId());
  }

  @Test
  public void getId_instantiateWithAnId_1() {
    Stylist testStylist = new Stylist("Lincoln");
    testStylist.save();
    assertTrue(testStylist.getId() > 0);
  }

  // @Test
  // public void find_returnsWithSameId_second() {
  //   Stylist firstStylist = new Stylist("Lincoln");
  //   firstStylist.save();
  //   Stylist secondStylist = new Stylist("Molly");
  //   secondStylist.save();
  //   assertEquals(Stylist.find(secondStylist.getId(),secondStylist));
  // }

  @Test
  public void getClients_retrievesALlClientsFromDb_clientsList() {
    Stylist myStylist = new Stylist("Lincoln");
    myStylist.save();
    Client firstClient = new Client("Molly", myStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Sam", myStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
  }
}
