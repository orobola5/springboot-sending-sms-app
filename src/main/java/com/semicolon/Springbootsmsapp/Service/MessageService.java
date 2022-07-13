package com.semicolon.Springbootsmsapp.Service;
import com.semicolon.Springbootsmsapp.Data.Model.MyMessage;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
@Component
public class MessageService {

    private  final String ACCOUNT_SID
            = "enter your SID Number from Twilio";
    private  final String AUTH_TOKEN
            = "enter your Auth token from Twilio Account";
    private final String FROM_NUMBER
            ="enter the phone number generated from Twilio";

    public void send(MyMessage sms) {
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber(sms.getTo()),
                new PhoneNumber(FROM_NUMBER),sms.getMessage()).create();
        System.out.println("here is my id:"+message.getSid());
    }

    public void receive(MultiValueMap<String, String> smsCall_Back) {

    }
}
