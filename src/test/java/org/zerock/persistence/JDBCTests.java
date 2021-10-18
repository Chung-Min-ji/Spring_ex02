package org.zerock.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.fail;


@Log4j
public class JDBCTests {

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch(Exception e) {
            e.printStackTrace();
        } //try-catch
    } //static

    @Test
    public void testConnection(){
        log.debug("testConnection() invoked.");

        try(Connection con =
                    DriverManager.getConnection(
                            "jdbc:oracle:thin:@localhost:1521:XE",
                            "BOOK_EX",
                            "oracle!!!"
                    )){
            log.info(con);

        }catch (Exception e){
            fail(e.getMessage());
        } //try-catch
    } //testConnection

} //end class
