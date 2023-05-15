package controllers;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
    render ("dashboard.html", stations);
  }

  public static void addStation(String name)
  {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name);
    Logger.info ("Adding a new station called " + name);
    member.stations.add(station);
    member.save();
    redirect ("/dashboard");
  }
}

