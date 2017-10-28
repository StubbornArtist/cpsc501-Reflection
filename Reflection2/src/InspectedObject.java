import java.util.ArrayList;
import java.util.HashMap;

public class InspectedObject extends InspectedBaseObject {

	private ArrayList<InspectedBaseObject> interfaces;
	private HashMap<String, InspectedBaseObject> fields;
	private InspectedBaseObject superClass;

	public InspectedObject(Object obj, boolean recursive) {
		super(obj, recursive);
		init();
	}

	public InspectedObject(InspectedBaseObject parent, InspectedClass type) {
		super(parent, type);
		init();
	}

	public InspectedObject(InspectedBaseObject parent, Object obj) {
		super(parent, obj);
		init();
	}

	private void init() {
		interfaces = getInterfaces();
		fields = getFields();
		superClass = getSuperClass();
	}

	public ArrayList<InspectedBaseObject> getInterfaces() {

		ArrayList<InspectedBaseObject> temp = new ArrayList<InspectedBaseObject>();
		for (InspectedClass c : getType().getInterfaces()) {
			temp.add(create(this, c));
		}

		return temp;
	}

	public InspectedBaseObject getSuperClass() {
		if (getType().hasSuperClass())
			return create(this, getType().getSuperClass());
		return null;
	}

	public HashMap<String, InspectedBaseObject> getFields() {

		HashMap<String, InspectedBaseObject> pairs = new HashMap<String, InspectedBaseObject>();
		InspectedClass objClass = getType();
		for (InspectedField f : objClass.getFields()) {
			InspectedBaseObject obj = create(this, f);
			pairs.put(f.getName(), obj);
		}

		return pairs;
	}

	private String fieldsToString() {
		String result = "\n\n";
		for (InspectedField f : getType().getFields()) {
			InspectedBaseObject val = fields.get(f.getName());
			result += f + "\n" + val + "\n\n";
		}
		return result;
	}

	@Override
	public String toString() {
		String result = super.toString();
		if (!fields.isEmpty()) {
			String fieldStr = fieldsToString();
			result += "\nFields : " + StringExtensions.indent(fieldStr);
		}
		if (!interfaces.isEmpty()) {
			String interfaceStr = StringExtensions.lineSeperatedString(interfaces);
			result += "\nInterfaces : " + StringExtensions.indent(interfaceStr);
		}
		if (!(superClass == null)) {
			result += "\nSuper : \n" + StringExtensions.indent(superClass.toString());
		}
		return result;
	}
}
