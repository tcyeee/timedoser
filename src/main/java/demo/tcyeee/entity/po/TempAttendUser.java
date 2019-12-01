package demo.tcyeee.entity.po;

import lombok.Data;

import javax.persistence.*;

/**
 * @author chenyueee
 * @since 2019/12/1 17:47
 */
@Data
@Entity
@Table(name = "temp_attend_user", schema = "time_doser")
public class TempAttendUser {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "user")
    private String user;

    @Column(name = "qing_user")
    private int qingUser;
}
