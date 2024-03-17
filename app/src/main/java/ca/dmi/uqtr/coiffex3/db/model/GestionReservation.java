package ca.dmi.uqtr.coiffex3.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reservations")
public class GestionReservation {

        @PrimaryKey(autoGenerate = true)
        private int id;

        @ColumnInfo(name = "client_name")
        private String clientName;

        @ColumnInfo(name = "date")
        private String date;

        @ColumnInfo(name = "time")
        private String heure;

        public GestionReservation(){}

        public GestionReservation(String clientName, String date, String time) {
            this.clientName = clientName;
            this.date = date;
            this.heure = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHeure() {
            return heure;
        }

        public void setHeure(String time) {
            this.heure= time;
        }
    }

