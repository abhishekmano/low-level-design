using System.Drawing;
using hotel_management_system.models;

namespace hotel_management_system.interfaces
{
    public interface IHotelManager { }

    public interface IHotelBookingManager : IHotelManager
    {
        public List<Room> GetAvailableRooms(DateTime start, DateTime end);

        public RoomBooking BookRoom(User user, Room room, DateTime start, DateTime end);
        public RoomBooking CancelRoom(string BookingId);
    }

    public interface IHotelCleaningManager : IHotelManager
    {
        public List<Room> GetRoomsToClean();
        public bool CleanRoom(Room room);
    }

    public interface IHotelReceptionManager : IHotelManager
    {
        public bool CheckInUser(User user, Room room);
        public bool CheckOutUser(User user, Room room);
    }

    public interface IHotelAdminManager : IHotelManager
    {
        public void AddRoom(Room room);
        public Room GetRoom(int roomId);
        public void EditRoom(Room room);
    }
}
