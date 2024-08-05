using hotel_management_system.interfaces;
using hotel_management_system.models;

public class RoomBooking
{
    public int BookingId { get; set; }
    public Guest Guest { get; set; }
    public List<Room> Rooms { get; set; }
    public DateTime StartTime { get; set; }
    public DateTime EndTime { get; set; }
    public BaseRoomCharge TotalRoomCharge { get; set; }
}
