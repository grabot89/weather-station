package controllers;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

import java.util.Comparator;
import java.util.List;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
    stations.sort(Comparator.comparing(Station::getName));
    render ("dashboard.html", stations);
  }

  public static void addStation(String name, double latitude, double longitude)
  {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name, latitude, longitude);
    Logger.info ("Adding a new station called " + name);
    member.stations.add(station);
    member.save();
    redirect ("/dashboard");
  }

  public static void deleteStation(Long id) {
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    Logger.info ("Deleting station " + id);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect ("/dashboard");
  }
}

