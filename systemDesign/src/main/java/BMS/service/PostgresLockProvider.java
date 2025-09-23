package BMS.service;

import BMS.enums.ShowSeatStatus;
import BMS.models.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PostgresLockProvider implements ILockProvider {

    ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, ShowSeatLock>> showMapMap = new ConcurrentHashMap<>();

    @Override
    public boolean acquireLock(List<ShowSeat> showSeatList, User user, Show show) throws InterruptedException {


        ConcurrentHashMap<Integer, ShowSeatLock> showSeatLockMap =
                showMapMap.computeIfAbsent(show.getId(), k -> new ConcurrentHashMap<>());

        synchronized (showSeatLockMap) {
            for (ShowSeat showSeat : showSeatList) {
                if (showSeatLockMap.containsKey(showSeat.getId())) {
                    return false;
                }
            }

            for (ShowSeat showSeat : showSeatList) {
                ShowSeatLock showSeatLock = new ShowSeatLock();
                showSeatLock.showSeat = showSeat;
                showSeatLock.lockedBy = user;
                showSeatLock.lockedAt = LocalDateTime.now();
                showSeatLock.lockedUntil = showSeatLock.lockedAt.plusMinutes(15);
                showSeatLockMap.put(showSeat.getId(),showSeatLock);
            }

            return true;
        }

    }
}
