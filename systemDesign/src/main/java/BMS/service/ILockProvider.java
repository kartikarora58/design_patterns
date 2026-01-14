package BMS.service;

import BMS.models.Show;
import BMS.models.ShowSeat;
import BMS.models.User;

import java.util.*;

public interface ILockProvider {

    boolean acquireLock(List<ShowSeat> showSeatList, User user, Show show) throws InterruptedException;

}
