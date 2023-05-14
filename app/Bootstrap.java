import java.util.List;

import play.*;
import play.jobs.*;
import play.test.*;

import models.*;
import util.StationUtil;

@OnApplicationStart
public class Bootstrap extends Job
{
  public void doJob()
  {
    StationUtil.loadMap();
    Fixtures.loadModels("data.yml");
  }
}

