

import org.example.service.StaffService;
import org.example.utils.MyBatisUtil;
import org.example.entity.Staff;
import org.example.mapper.StaffMapper;
import org.apache.ibatis.session.SqlSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StaffTest {
    public static void main(String[] args) {
        StaffService.deleteStaffByProvince("陕西");
        StaffService.selectByAddr(1);
        StaffService.ariseSalByAge(27);
    }
}