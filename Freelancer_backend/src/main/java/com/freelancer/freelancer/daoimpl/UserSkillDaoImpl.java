import com.freelancer.freelancer.dao.UserSkillDao;
import com.freelancer.freelancer.entity.UserSkill;
import com.freelancer.freelancer.repository.UserSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserSkillDaoImpl implements UserSkillDao {

    @Autowired
    UserSkillRepository userSkillRepository;

    @Override
    public void addUserSkill(UserSkill newUserSkill) {
        System.out.println("daoimpl test");
        userSkillRepository.save(newUserSkill); }

}