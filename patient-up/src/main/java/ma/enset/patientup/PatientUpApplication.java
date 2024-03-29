package ma.enset.patientup;

import ma.enset.patientup.entities.Patient;
import ma.enset.patientup.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientUpApplication {

	public static void main(String[] args) {

		SpringApplication.run(PatientUpApplication.class, args);
	}
	//@Bean
	public CommandLineRunner start(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(
					new Patient(null,"Ahmed",new Date(),false,120)
			);
			patientRepository.save(
					new Patient(null,"Ayman",new Date(),false,120)
			);
			patientRepository.save(
					new Patient(null,"Houssam",new Date(),true,102)
			);
			patientRepository.save(
					new Patient(null,"Salem",new Date(),false,540)
			);

			patientRepository.findAll().forEach(p->{
				System.out.println(p.getNom());
			});
		};
	}

    @Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
