package edu.ifmo.zad4;

import java.io.IOException;
import javax.servlet.http.*;

public class Zad4 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String number = req.getParameter("number");
		Cars[] cars = createCars();
		Cars car, car1, car2 = null;

		Track[] tracks = createTracks();
		Track track = null;

		if (action.equals("1")) {
			String carId = req.getParameter("carId");
			car = setCar(carId, cars);
			resp.getWriter().print(
					"<b>Информация об автомобиле:</b><br />Модель: "
							+ car.model + "<br> Макс. скорость: "
							+ car.speedStraight
							+ "<br> Коэффициент управляемости: " + car.control
							+ "<br> Воздействие ветра: " + car.windEff
							+ "<br> Воздействие дождя: " + car.rainEff);
		}

		if (action.equals("2")) {
			String trackId = req.getParameter("trackId");
			track = setTrack(trackId, tracks);
			resp.getWriter().print(
					"<img src=\"" + track.src
							+ "\" style=\"width:400px; height:300px\">");
		}

		if (action.equals("3")) {
			if (req.getParameter("carId1").isEmpty()
					|| req.getParameter("carId2").isEmpty()
					|| req.getParameter("trackId").isEmpty()
					|| req.getParameter("rain").isEmpty()
					|| req.getParameter("wind").isEmpty()) {
				resp.getWriter().println("<b>Заполните все поля!</b>");
			} else {
				Weather wth = new Weather();
				wth.rain = Double.parseDouble(req.getParameter("rain"));
				wth.windSpeed = Double.parseDouble(req.getParameter("wind"));

				String carId1 = req.getParameter("carId1");
				String carId2 = req.getParameter("carId2");
				String trackId = req.getParameter("trackId");

				car1 = setCar(carId1, cars);
				car2 = setCar(carId2, cars);
				track = setTrack(trackId, tracks);

				wth.setWeatherToCar(car1);
				wth.setWeatherToCar(car2);

				System.out.println(car1.rainEff + "  " + car2.rainEff);
				track.setTimeTurn(car1);
				track.setTimeTurn(car2);

				resp.getWriter().println(
						"<b> Итоговое время: <br>Первый автомобиль: "
								+ car1.resultTime(track)
								+ " секунд<br>Второй автомобиль: "
								+ car2.resultTime(track) + " секунд</b>");
			}

		}
	}

	private Cars[] createCars() {
		Cars[] cars = new Cars[4];

		Cars car1 = new Cars();
		car1.carId = "1";
		car1.model = "Chevrolet Camaro";
		car1.speedStraight = 240;
		car1.control = 0.7;
		car1.windEff = 0.5;
		car1.rainEff = 0.4;
		cars[0] = car1;

		Cars car2 = new Cars();
		car2.carId = "2";
		car2.model = "Ford Mustang";
		car2.speedStraight = 223;
		car2.control = 0.9;
		car2.windEff = 0.7;
		car2.rainEff = 0.2;
		cars[1] = car2;

		Cars car3 = new Cars();
		car3.carId = "3";
		car3.model = "Audi R8";
		car3.speedStraight = 301;
		car3.control = 0.4;
		car3.windEff = 0.3;
		car3.rainEff = 0.4;
		cars[2] = car3;

		Cars car4 = new Cars();
		car4.carId = "4";
		car4.model = "Lada Priora";
		car4.speedStraight = 172;
		car4.control = 0.4;
		car4.windEff = 0.7;
		car4.rainEff = 0.6;
		cars[3] = car4;

		return cars;
	}

	private Track[] createTracks() {
		Track[] tracks = new Track[3];

		Track track1 = new Track();
		track1.trackId = "1";
		track1.src = "/img/track1.jpg";
		track1.trackName = "Лондон";
		track1.lenTrack = 3.5;
		track1.turns = 4;
		track1.lenTurns = 140;
		tracks[0] = track1;

		Track track2 = new Track();
		track2.trackId = "2";
		track2.src = "/img/track2.jpg";
		track2.trackName = "Париж";
		track2.lenTrack = 13.1;
		track2.turns = 7;
		track2.lenTurns = 214;
		tracks[1] = track2;

		Track track3 = new Track();
		track3.trackId = "3";
		track3.src = "/img/track3.jpg";
		track3.trackName = "Флорида";
		track3.lenTrack = 10.4;
		track3.turns = 14;
		track3.lenTurns = 170;
		tracks[2] = track3;

		return tracks;

	}

	private Cars setCar(String carId, Cars[] cars) {
		Cars car = new Cars();
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].carId.equals(carId)) {
				car = cars[i];
				break;
			}
		}
		return car;
	}

	private Track setTrack(String trackId, Track[] tracks) {
		Track track = new Track();
		for (int i = 0; i < tracks.length; i++) {
			if (tracks[i].trackId.equals(trackId)) {
				track = tracks[i];
				break;
			}
		}
		return track;
	}
}
