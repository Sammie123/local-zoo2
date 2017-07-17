import org.junit.*;
import static org.junit.Assert.*;


public class ClientTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteClientsQuery = "DELETE FROM clients *;";
      String deleteStylistsQuery = "DELETE FROM stylists *;";
      con.createQuery(sql).executeUpdate();
    }
  }

  @Test
  public void Client_instantiatesTrue_true() {
    Client myClient = new Client("Molly", 1);
    assertEquals(true, myClient instanceof Client);
  }

  @Test
  public void Client_instantiatesWithName_String() {
    Client myClient = new Client("Molly", 1);
    assertEquals("Molly", myClient.getName());
  }

  @Test
  public void all_returnsAllInstances_true() {
    Client firstClient = new Client("Molly", 1);
    firstClient.save();
    Client secondClient = new Client("Sam", 1);
    secondClient.save();
    assertEquals(true, Client.all().get(0).equals(firstClient));
    assertEquals(true, Client.all().get(1).equals(secondClient));
  }

  @Test
  public void save_assignsIdToObject() {
    Client myClient = new Client("Molly", 1);
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(myClient.getId(), savedClient.getId());
  }

  @Test
  public void getId_instantiateWithAnID() {
    Client myClient = new Client("Molly", 1);
    myClient.save();
    assertTrue(myClient.getId() > 0);
  }

  @Test
  public void find_returnsWithSameId_secondClient() {
    Client firstClient = new Client("Molly", 1);
    firstClient.save();
    Client secondClient = new Client("Sam", 1);
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

  @Test
  public void save_savesIdIntoDB_true() {
    Stylist myStylist = new Stylist("Lincoln");
    myStylist.save();
    Client myClient = new Client("Molly", myStylist.getId());
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertEquals(savedClient.getStylistId(), myStylist.getId());
  }

  @Test
  public void update_updatesName_true() {
    Client myClient = new Client("Molly", 1);
    myClient.save();
    myClient.update("Molly Johnson");
    assertEquals("Molly Johnson", Client.find(myClient.getId()).getName());
  }

  @Test
  public void delete_deleteClient_true() {
    Client myClient = new Client("Molly, 1");
    myClient.save();
    int myClientId = myClient.getId();
    myClient.delete();
    assertEquals(null, Client.find(myClientId));
  }


}
