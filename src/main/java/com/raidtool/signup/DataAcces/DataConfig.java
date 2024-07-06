package com.raidtool.signup.DataAcces;


import com.raidtool.signup.Entities.Characters;
import com.raidtool.signup.Entities.EventDetails;
import com.raidtool.signup.Entities.Events;
import com.raidtool.signup.Entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {


    @Bean
    public Class<User> userClass() {
        return User.class;
    }

    public Class<Characters> charactersClass() {
        return Characters.class;
    }

    public Class<Events> eventsClass() {
        return Events.class;
    }

    public Class<EventDetails> eventDetailsClass() {
        return EventDetails.class;
    }


}
