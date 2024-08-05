using hotel_management_system.interfaces;

namespace hotel_management_system.models
{
    public abstract class User
    {
        public string Name { get; set; }
        public string Phone { get; set; }
        public IHotelManager HotelManager { get; set; }
    }

    public class HouseKeeper : User { }

    public class Admin : User { }

    public class Guest : User { }

    public class Receptionist : User { }

    public class Account
    {
        public string Username { get; set; }
        public string Password { get; set; }
        public AccountStatus AccountStatus { get; set; }
    }

    public enum AccountStatus
    {
        ACTIVE,
        BLOCKED,
        CLOSED
    }
}
