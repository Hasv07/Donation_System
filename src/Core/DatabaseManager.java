package Core;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    public static final String DB_NAME = "system.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\walid\\Documents\\GitHub\\Donation_System\\DataBase\\" + DB_NAME;

    public static final String TABLE_DONORS = "donors";
    public static final String COLUMN_DONOR_ID = "_id";
    public static final String COLUMN_DONOR_USERNAME = "username";
    public static final String COLUMN_DONOR_PASSWORD = "password";
    public static final String COLUMN_DONOR_NAME = "name";
    public static final String COLUMN_DONOR_EMAIL = "email";
    public static final String COLUMN_DONOR_ADDRESS = "address";
    public static final String COLUMN_DONOR_PHONENUMBER = "phonenumber";

    public static final String TABLE_CHARITIES = "charities";
    public static final String COLUMN_CHARITY_ID = "_id";
    public static final String COLUMN_CHARITY_NAME = "name";
    public static final String COLUMN_CHARITY_CATEGORY = "category";
    public static final String COLUMN_CHARITY_DESCRIPTION = "description";
    public static final String COLUMN_CHARITY_LINK = "link";
    public static final String COLUMN_CHARITY_EMAIL = "email";

    public static final String TABLE_DONATIONS = "donations";
    public static final String COLUMN_DONATION_ID = "_id";
    public static final String COLUMN_DONATION_AMOUNT = "amount";
    public static final String COLUMN_DONATION_DONOR = "donor";
    public static final String COLUMN_DONATION_CHARITY = "charity";


    public static final String QUERY_DONORS = "SELECT * FROM " + TABLE_DONORS + " ORDER BY " + COLUMN_DONOR_USERNAME + " COLLATE NOCASE";

    public static final String QUERY_CHARITIES = "SELECT * FROM " + TABLE_CHARITIES + " ORDER BY " + COLUMN_CHARITY_NAME + " COLLATE NOCASE";

    public static final String QUERY_DONOR_DONATIONS = "SELECT " + TABLE_DONATIONS + "." + COLUMN_DONATION_ID + " , " + TABLE_DONATIONS + "." + COLUMN_DONATION_AMOUNT
            + " , " + TABLE_CHARITIES + "." + COLUMN_CHARITY_NAME + " FROM "
            + TABLE_DONATIONS + " INNER JOIN " + TABLE_DONORS + " ON " + TABLE_DONATIONS + "." + COLUMN_DONATION_DONOR + " = " + TABLE_DONORS + "." +
            COLUMN_DONOR_ID + " INNER JOIN " + TABLE_CHARITIES + " ON " + TABLE_DONATIONS + "." + COLUMN_DONATION_CHARITY + " = " + TABLE_CHARITIES + "." +
            COLUMN_CHARITY_ID + " WHERE " + TABLE_DONORS + "." + COLUMN_DONOR_USERNAME + " = ?";

    public static final String INSERT_DONOR="INSERT INTO "+ TABLE_DONORS+"("+COLUMN_DONOR_USERNAME+", "+COLUMN_DONOR_PASSWORD+", "+COLUMN_DONOR_NAME+", "+
            COLUMN_DONOR_EMAIL+", "+COLUMN_DONOR_ADDRESS+", "+COLUMN_DONOR_PHONENUMBER+")"+" VALUES(?, ?, ?, ?, ?, ?)";


    public static final String INSERT_CHARITY="INSERT INTO "+ TABLE_CHARITIES+"("+COLUMN_CHARITY_NAME+", "+COLUMN_CHARITY_CATEGORY+", "+COLUMN_CHARITY_DESCRIPTION+", "+
            COLUMN_CHARITY_LINK+", "+COLUMN_CHARITY_EMAIL+")"+" VALUES(?, ?, ?, ?, ?)";

    public static final String INSERT_DONATION="INSERT INTO "+ TABLE_DONATIONS+"("+COLUMN_DONATION_AMOUNT+", "+COLUMN_DONATION_DONOR+", "+COLUMN_DONATION_CHARITY+
            ")"+" VALUES(?, ?, ?)";

    public static final String QUERY_DONOR = "SELECT "+ COLUMN_DONOR_ID+ " FROM "+ TABLE_DONORS+" WHERE "+COLUMN_DONOR_USERNAME+" = ?";
    public static final String QUERY_CHARITY = "SELECT "+ COLUMN_CHARITY_ID+ " FROM "+ TABLE_DONORS+" WHERE "+COLUMN_CHARITY_NAME+" = ?";



    private Connection conn;
    private PreparedStatement queryDonorDonations;
    private PreparedStatement insertDonor;
    private PreparedStatement insertCharity;
    private PreparedStatement insertDonation;
    private PreparedStatement queryDonor;
    private PreparedStatement queryCharity;

    private static DatabaseManager instance = new DatabaseManager();

    private DatabaseManager() {

    }

    public static DatabaseManager getInstance() {
        return instance;
    }

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);

            queryDonorDonations = conn.prepareStatement(QUERY_DONOR_DONATIONS);
            insertDonor = conn.prepareStatement(INSERT_DONOR);
            insertCharity = conn.prepareStatement(INSERT_CHARITY);
            insertDonation = conn.prepareStatement(INSERT_DONATION);
            queryDonor = conn.prepareStatement(QUERY_DONOR);
            queryCharity = conn.prepareStatement(QUERY_CHARITIES);


            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (queryDonor != null) {
                queryDonor.close();
            }
            if (queryCharity != null) {
                queryCharity.close();
            }

            if (insertDonor != null) {
                insertDonor.close();
            }
            if (insertCharity != null) {
                insertCharity.close();
            }
            if (insertDonation != null) {
                insertDonation.close();
            }

            if (queryDonorDonations != null) {
                queryDonorDonations.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }


    public List<Donor> queryDonors() {

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(QUERY_DONORS)) {

            List<Donor> donors = new ArrayList<>();
            while (results.next()) {

                Donor donor = new Donor();
                donor.setId(results.getInt(COLUMN_DONOR_ID));
                donor.setUsername(results.getString(COLUMN_DONOR_USERNAME));
                donor.setPassword(results.getString(COLUMN_DONOR_PASSWORD));
                donor.setEmail(results.getString(COLUMN_DONOR_EMAIL));
                donor.setName(results.getString(COLUMN_DONOR_NAME));
                donor.setPhoneNumber(results.getString(COLUMN_DONOR_PHONENUMBER));
                donor.setAddress(results.getString(COLUMN_DONOR_ADDRESS));

                donors.add(donor);
            }

            return donors;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }


    public List<Charity> queryCharities() {

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(QUERY_CHARITIES)) {

            List<Charity> charities = new ArrayList<>();
            while (results.next()) {

                Charity charity = new Charity();
                charity.setId(results.getInt(COLUMN_CHARITY_ID));
                charity.setName(results.getString(COLUMN_CHARITY_NAME));
                charity.setCategory(results.getString(COLUMN_CHARITY_CATEGORY));
                charity.setLink(results.getString(COLUMN_CHARITY_LINK));
                charity.setDescription(results.getString(COLUMN_CHARITY_DESCRIPTION));
                charity.setEmail(results.getString(COLUMN_CHARITY_EMAIL));

                charities.add(charity);
            }

            return charities;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<String> queryDonationsForDonor(String username) {

        try {
            queryDonorDonations.setString(1, username);
            ResultSet results = queryDonorDonations.executeQuery();
            List<String> donations = new ArrayList<>();
            while (results.next()) {
                donations.add(results.getString(COLUMN_DONATION_ID));
                donations.add(results.getString(COLUMN_DONATION_AMOUNT));
                donations.add(results.getString(COLUMN_CHARITY_NAME));
            }

            return donations;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    private int insertDonor(Donor donor) throws SQLException{ //the caller handle the exception
        queryDonor.setString(1,donor.getUsername());
        ResultSet results =queryDonor.executeQuery();
        if(results.next()){
            return results.getInt(1);
        }
        else{
            insertDonor.setString(1,donor.getUsername());
            insertDonor.setString(2,donor.getPassword());
            insertDonor.setString(3,donor.getName());
            insertDonor.setString(4,donor.getEmail());
            insertDonor.setString(5,donor.getAddress());
            insertDonor.setString(6,donor.getPhoneNumber());
            insertDonor.executeUpdate();
            return 0;
        }

    }





}
