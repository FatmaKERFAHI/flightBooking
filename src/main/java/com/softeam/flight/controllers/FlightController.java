package com.softeam.flight.controllers;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softeam.flight.entities.Airport;
import com.softeam.flight.entities.Flight;
import com.softeam.flight.entities.Reservation;
import com.softeam.flight.enums.ClassVol;
import com.softeam.flight.enums.TypeVol;
import com.softeam.flight.repositories.FlightRepository;
import com.softeam.flight.repositories.ReservationRepository;
import com.softeam.flight.services.AirportService;
import com.softeam.flight.services.FlightService;

import io.swagger.annotations.ApiOperation;


// TODO: Auto-generated Javadoc
/**
 * The Class FlightController.
 * @author Fatma KERFAHI
 */


@CrossOrigin
@RestController
@RequestMapping(value = "/flight")
public class FlightController {
	
	/** The flight service. */
	@Autowired
	private FlightService flightService;
	@Autowired
	private FlightRepository flightrepository;
	@Autowired
	private ReservationRepository reservrepo;
	  
	/**
	 * @author Fatma KERFAHI
	 */	
	@PostMapping(value= "/save")
	@ApiOperation(value = "Save flight", response = Flight.class, responseContainer = "ResponseEntity")
	public ResponseEntity<Flight> createDeveloper(@RequestBody Flight flight) {
		Flight savedFlight = flightService.saveFlight(flight);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idFlight}")
				.buildAndExpand(savedFlight.getIdFlight()).toUri();

		return ResponseEntity.created(location).build();

	}
	/**
	 * @author Fatma KERFAHI
	 */	
	/**
	 * Find flights.
	 *
	 * @param departureDate the departure date
	 * @param arrivalDate the arrival date
	 * @param flightFrom the flight from
	 * @param flightTo the flight to
	 * @param classVol the class vol
	 * @param typeVol the type vol
	 * @return the response entity
	 */
	
	@GetMapping(value= "/search")
	public ResponseEntity<List<Flight>> findFlights(
			@RequestParam(value="departureDate", required=true) @DateTimeFormat(pattern = "yyyy-MM-dd") String departureDate,
			@RequestParam(value="arrivalDate", required=true)  @DateTimeFormat(pattern = "yyyy-MM-dd") String arrivalDate,
			@RequestParam(value="flightFrom", required=true) String flightFrom,
			@RequestParam(value="flightTo", required=true) String flightTo,
			@RequestParam(value="classVol", required=false) ClassVol classVol,
			@RequestParam(value="typeVol", required=false) TypeVol typeVol) {
		List<Flight> flights = flightService.getFlightsByWhere(departureDate, arrivalDate, flightFrom, flightTo, classVol, typeVol) ;
        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK) ;
	}
	
	/** The country service. */
	@Autowired
	private AirportService airportService;
	
	/**
	 * Gets the all aeroports.
	 *
	 * @return the all aeroports
	 */
	@GetMapping(value = "/airports")
	public ResponseEntity<List<Airport>> getAllAeroports() {
		List<Airport> allAirports = airportService.getAllAirports();
        return new ResponseEntity<List<Airport>>(allAirports, HttpStatus.OK) ;
	}
	
	@GetMapping(value = "/fetchFlight/{flightId}")
	public ResponseEntity<Flight> getFlightById(@PathVariable("flightId") String flightId) {
		Flight flight = flightService.findById(flightId);
        return new ResponseEntity<Flight>(flight, HttpStatus.OK) ;
	}
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @author Ibtihel khemir
	 */	
	@PostMapping("/addflight")
	public boolean addflight(@RequestBody Flight fl) 
	{
		System.out.println("je suis l'administrateur, je veux ajouter un vol");
		System.out.println(fl);
		if (flightrepository.existsByidFlight(fl.getIdFlight()))
		{
		 return false;
		}
		else 
		{
		flightrepository.save(fl);
		return true;
		}
	}
	
	/**
	 * @author Ibtihel khemir
	 */	
	
	@PostMapping("/dropflight/{idFlight}")
	public void dropflight(@PathVariable("idFlight") String id) 
	{
		System.out.println("je suis l'admin et je veux supprimer un vol ");
		
		System.out.println(id);
		
		if (flightrepository.existsByidFlight(id))
		{
			Flight fl = flightrepository.findByidFlight(id);
			sendEmail(listemail(id),fl);
			//reservrepo.delete(reservrepo.findByflight(id));
			flightrepository.deleteById(id);
			System.out.println("vol supprimeé");
		}
		else 
		{
			System.out.println("n'exite pas");
		}
	}
	/**
	 * @author Ibtihel khemir
	 */	
	///// recuperer  les adress mail des personne impacter par la supression des vol.
	public List<String> listemail(String idFlight) {
		
		List<Reservation> res = new ArrayList<Reservation>();
		List<String> listmail = new ArrayList<String>();
		res = reservrepo.findAll();
		 for(int i=0; i<res.size(); i++)
		 {
	            System.out.println(res.get(i)); 
	            if( (res.get(i).getFlight().getIdFlight()) == idFlight)
	            System.out.println((res.get(i).getPassenger().getEmail()));
	            listmail.add(i, (res.get(i).getPassenger().getEmail()));
		 }
		return listmail;
		
	}
	
	/**
	 * @author Ibtihel khemir
	 */	
	
	@GetMapping("/searchI/{idFlight}") 
	public Flight getflight(@PathVariable("idFlight") String id) 
	{
		System.out.println(id);
		return  flightrepository.findByidFlight(id);
	
	}
	/**
	 * @author Ibtihel khemir
	 */	
	
	@GetMapping("/searchAll") 
	public List<Flight> getallflight() 
	{
		
		return  flightrepository.findAll();
	
	}
	/**
	 * @author Ibtihel khemir
	 */	 
	public void sendEmail(List<String> emails,Flight fl) {
        final String username = "flightbooking2020@gmail.com";
          final String password = "Softeam2020";
          Properties prop = new Properties();
          prop.put("mail.smtp.host", "smtp.gmail.com");
          prop.put("mail.smtp.port", "587");
          prop.put("mail.smtp.auth", "true");
          prop.put("mail.smtp.starttls.enable", "true");
          
          Session session = Session.getInstance(prop,new javax.mail.Authenticator() {
                      protected PasswordAuthentication getPasswordAuthentication() {
                          return new PasswordAuthentication(username, password);
                      }
                  });
          for(int i=0; i<emails.size(); i++)
 		 {
          
          try {
              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress("flightbooking2020@gmail.com"));
              message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emails.get(i)) // <mail en parametre
              );
              message.setSubject("Annulation de vol ");
              message.setText("Cher Utilisateur,"+ "\n\n Merci pour votre fidélité nous somme contraint d'annuler votre vol au depart de"+fl.getDeparture()+"à"+fl.getArrivalDate()+"a destination de "+fl.getArrival()+"à"+fl.getArrivalDate()+".\nUn Rambourcement sera effectueé dans les prochain 48H.\n Pour choisir un autre vol je vous invite a consulter ");
              Transport.send(message);
              System.out.println("Done");
          } catch (MessagingException e) {
              e.printStackTrace();
          }
 		 }
  }
	/**
	 * @author Ibtihel khemir
	 */	
	////////////////////// envoie de mail de confirmation de resrvation ////////
	@PostMapping("/confirmation")
	public void sendEmailReservation(@RequestBody String email,@RequestBody String cormail) {
        final String username = "flightbooking2020@gmail.com";
          final String password = "Softeam2020";
          Properties prop = new Properties();
          prop.put("mail.smtp.host", "smtp.gmail.com");
          prop.put("mail.smtp.port", "587");
          prop.put("mail.smtp.auth", "true");
          prop.put("mail.smtp.starttls.enable", "true");
          
          Session session = Session.getInstance(prop,new javax.mail.Authenticator() {
                      protected PasswordAuthentication getPasswordAuthentication() {
                          return new PasswordAuthentication(username, password);
                      }
                  });
         
          try {
              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress("flightbooking2020@gmail.com"));
              message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email) // <mail en parametre
              );
              message.setSubject("Confirmation du vol ");
              message.setText(cormail);
              Transport.send(message);
              System.out.println("Done");
          } catch (MessagingException e) {
              e.printStackTrace();
          }
 		 
  }
	
}
