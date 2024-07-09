using hotel_management_system.interfaces;
using hotel_management_system.models;

namespace hotel_management_system.service
{
    public class HotelBookingManager : IHotelBookingManager
    {
        public Hotel Hotel { get; set; }

        public HotelBookingManager(Hotel hotel)
        {
            Hotel = hotel;
        }

        public List<Room> GetAvailableRooms(DateTime start, DateTime end)
        {
            return [];
        }

        public RoomBooking BookRoom(User user, Room room, DateTime start, DateTime end)
        {
            return new();
        }

        public RoomBooking CancelRoom(string bookingId)
        {
            return new();
        }
    }

    public class HotelAdminManager : IHotelAdminManager
    {
        public Hotel Hotel { get; set; }

        public HotelAdminManager(Hotel hotel)
        {
            Hotel = hotel;
        }

        public void AddRoom(Room room)
        {
            Hotel.Rooms.Add(room);
        }

        public void EditRoom(Room room)
        {
            var requiredRoom = GetRoom(room.RoomNumber);
            requiredRoom.Price = room.Price;
            requiredRoom.RoomStyle = room.RoomStyle;
            //to do
        }

        public Room GetRoom(int roomId)
        {
            var requiredRoom = Hotel.Rooms.Where(r => r.RoomNumber == roomId).First();
            return requiredRoom;
        }
    }

    public class HotelReceptionManger : IHotelReceptionManager
    {
        public Hotel Hotel { get; set; }

        public HotelReceptionManger(Hotel hotel)
        {
            Hotel = hotel;
        }

        public bool CheckInUser(User user, Room room)
        {
            var required = Hotel.Rooms.Find(x => x.RoomNumber == room.RoomNumber);
            if (required is null)
                return false;
            required.RoomStatus = RoomStatus.OCCUPIED;
            return true;
        }

        public bool CheckOutUser(User user, Room room)
        {
            var required = Hotel.Rooms.Find(x => x.RoomNumber == room.RoomNumber);
            if (required is null)
                return false;
            required.RoomStatus = RoomStatus.AVAILABLE;
            return true;
        }
    }
}
