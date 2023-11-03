package respositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

public interface TaskRespositorio extends JpaRepository<Task, Long>	{

}
