package ma.enset.patientup;

import ma.enset.patientup.entities.Patient;
import ma.enset.patientup.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientUpApplication {

	public static void main(String[] args) {

		SpringApplication.run(PatientUpApplication.class, args);
	}
	@Bean
	public CommandLineRunner start(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(
					new Patient(null,"Ahmed",new Date(),false,12)
			);
			patientRepository.save(
					new Patient(null,"Ayman",new Date(),false,120)
			);
			patientRepository.save(
					new Patient(null,"Houssam",new Date(),true,10)
			);
			patientRepository.save(
					new Patient(null,"Salem",new Date(),false,54)
			);

			patientRepository.findAll().forEach(p->{
				System.out.println(p.getNom());
			});
		};
	}

}
