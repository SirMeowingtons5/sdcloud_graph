import com.sun.istack.internal.NotNull;

/**
 * Class-wrapper for each column with <b>ID</b>, <b>DisplayName</b> and <b>UnitName</b> fields
 * @author Viacheslav Tarannikov
 * @version 0.1a
 */
public class Column {
    private String id;
    private String displayName;
    private String unitName;

    /**
     * Constructor
     * @param id - Column ID
     * @param displayName - Column displayed name
     * @param unitName - Column's unit name
     */
    public Column(@NotNull String id, @NotNull String displayName, @NotNull String unitName){
        this.id = id;
        this.displayName = displayName;
        this.unitName = unitName;
    }

    /**
     * Function returns current column's ID
     * @see Column#id
     * @return ID of the current column
     */
    String getId(){
        return id;
    }

    /**
     * Function returns current column's Displayed Name
     * @see Column#displayName
     * @return Displayed Name of the current column
     */
    String getDisplayName(){
        return displayName;
    }

    /**
     * Function returns current column's unit name
     * @see Column#unitName
     * @return Unit Name of the current column
     */
    String getUnitName(){
        return unitName;
    }

}
