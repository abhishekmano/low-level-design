using hotel_management_system.models;

public class HouseKeepingLog
{
    public string Details { get; set; }
    public DateTime startTime { get; set; }
    public int Duration { get; set; }
    public HouseKeeper HouseKeeper { get; set; }
}
