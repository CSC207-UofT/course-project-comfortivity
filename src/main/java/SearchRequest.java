public class SearchRequest implements RequestInterface{
    int student_id;
    int filter_distance;
    List buildings_list;

    public SearchRequest(int student_id, int filter_distance, List buildings_list) {
        this.student_id = student_id;
        this.filter_distance = filter_distance;
        this.buildings_list = buildings_list;
    }

}
