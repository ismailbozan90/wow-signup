package com.raidtool.signup.DTO;

import com.raidtool.signup.Entities.EventDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private String title;
    private String description;
    private Date endDate;
    private List<EventDetail> eventDetailList;

}
