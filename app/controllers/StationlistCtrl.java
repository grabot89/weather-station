package controllers;

import models.Station;
import play.Logger;
import play.mvc.Controller;


public class StationlistCtrl extends Controller {
  public static void index(Long id)
  {
    Station station = Station.findById(id);
    Logger.info ("Station id = " + id);
    render("station.html", station);
  }

}
