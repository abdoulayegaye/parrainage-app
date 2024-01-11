package sn.dev.parrainageapp.tools;

import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class Notification {

    public static void NotifSuccess(String titre, String message){
        NotificationType type = NotificationType.SUCCESS;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(titre);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(2));
    }

    public static void NotifError(String titre, String message){
        NotificationType type = NotificationType.ERROR;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(titre);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(2));
    }
}
