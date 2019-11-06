package org.polytech.al.project1920.transfer.services;

import java.util.List;

public interface IRequestTransfert {
    public boolean requestTransfer(String senderId, String receiverId, float amount);

}
