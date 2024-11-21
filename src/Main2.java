import java.util.*;

interface HotelServiceInterface {
    List<Hotel> searchHotels(String location, String classType, double minPrice, double maxPrice);
    Hotel getHotel(String hotelId);
    boolean isRoomAvailable(String hotelId, String roomType, Date startDate, Date endDate);
    void addHotel(Hotel hotel);
}

interface BookingServiceInterface {
    Booking createBooking(String userId, String hotelId, String roomType, Date startDate, Date endDate);
    Booking getBooking(String bookingId);
    void confirmBooking(String bookingId);
    List<Booking> getUserBookings(String userId);
}

interface PaymentServiceInterface {
    boolean processPayment(Booking booking, String paymentMethod);
}

interface NotificationServiceInterface {
    void sendBookingConfirmation(Booking booking);
    void sendPaymentConfirmation(Booking booking);
}

interface UserManagementServiceInterface {
    User authenticateUser(String username, String password);
    User registerUser(String username, String password);
    User getUser(String userId);
}

class Hotel {
    String hotelId;
    String name;
    String location;
    Map<String, Integer> roomTypes;

    public Hotel(String hotelId, String name, String location, Map<String, Integer> roomTypes) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.roomTypes = roomTypes;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId='" + hotelId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", roomTypes=" + roomTypes +
                '}';
    }

    public String getHotelId() { return hotelId; }
    public int getRoomCount(String roomType) { return roomTypes.getOrDefault(roomType, 0); }
    public void reduceRoomCount(String roomType) { roomTypes.put(roomType, roomTypes.get(roomType) - 1); }
}

class Booking {
    String bookingId;
    String userId;
    String hotelId;
    String roomType;
    Date startDate;
    Date endDate;
    boolean confirmed;
    boolean paid;

    public Booking(String bookingId, String userId, String hotelId, String roomType, Date startDate, Date endDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.confirmed = false;
        this.paid = false;
    }

    public String getBookingId() { return bookingId; }
    public String getHotelId() { return hotelId; }
    public String getRoomType() { return roomType; }
    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }
    public void setPaid(boolean paid) { this.paid = paid; }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", userId='" + userId + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", confirmed=" + confirmed +
                ", paid=" + paid +
                '}';
    }
}

class User {
    String userId;
    String username;
    String password;

    public User(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public String getUserId() { return userId; }
}

class HotelServiceImpl implements HotelServiceInterface {
    Map<String, Hotel> hotels = new HashMap<>();

    @Override
    public List<Hotel> searchHotels(String location, String classType, double minPrice, double maxPrice) {
        return List.of();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return null;
    }

    @Override
    public boolean isRoomAvailable(String hotelId, String roomType, Date startDate, Date endDate) {
        return false;
    }

    @Override public void addHotel(Hotel hotel) { hotels.put(hotel.hotelId, hotel); }
    // ... other methods
}

class BookingServiceImpl implements BookingServiceInterface {
    Map<String, Booking> bookings = new HashMap<>();

    @Override
    public Booking createBooking(String userId, String hotelId, String roomType, Date startDate, Date endDate) {
        return null;
    }

    @Override
    public Booking getBooking(String bookingId) {
        return null;
    }

    @Override
    public void confirmBooking(String bookingId) {

    }

    @Override
    public List<Booking> getUserBookings(String userId) {
        return List.of();
    }
    // ... other methods
}

class PaymentServiceImpl implements PaymentServiceInterface {
    @Override public boolean processPayment(Booking booking, String paymentMethod) {
        System.out.println("Оплата " + booking.bookingId + " методом " + paymentMethod + " произведена.");
        return true;
    }
}

class NotificationServiceImpl implements NotificationServiceInterface {
    @Override public void sendBookingConfirmation(Booking booking) {
        System.out.println("Уведомление о подтверждении бронирования " + booking.bookingId + " отправлено пользователю " + booking.userId);
    }

    @Override
    public void sendPaymentConfirmation(Booking booking) {

    }
}

class UserManagementServiceImpl implements UserManagementServiceInterface {
    Map<String, User> users = new HashMap<>();

    @Override
    public User authenticateUser(String username, String password) {
        return null;
    }

    @Override
    public User registerUser(String username, String password) {
        return null;
    }

    @Override
    public User getUser(String userId) {
        return null;
    }
    // ... other methods
}

public class Main2 {
    public static void main(String[] args) {
        HotelServiceInterface hotelService = new HotelServiceImpl();
        BookingServiceInterface bookingService = new BookingServiceImpl();
        PaymentServiceInterface paymentService = new PaymentServiceImpl();
        NotificationServiceInterface notificationService = new NotificationServiceImpl();
        UserManagementServiceInterface userManagementService = new UserManagementServiceImpl();

        hotelService.addHotel(new Hotel("hotel1", "Hilton", "New York", Map.of("single", 10, "double", 5)));
        hotelService.addHotel(new Hotel("hotel2", "Marriott", "London", Map.of("single", 8, "suite", 2)));

        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
}