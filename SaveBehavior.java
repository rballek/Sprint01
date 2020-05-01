public interface SaveBehavior {
    public void save();

    public void save(String threatLevel, String weapon, String actionRequired, String comments);

    public void save(String threatLevel, String amountOfPeople, String actionRequiered, String possibleCrime, String comments);

    public void save(String weatherConditions, String weatherSeverity, String comments);
}
