/**
 * TODO
 * 将一个字符串中的每个空格替换成 "%20".
 * 例如，当字符串为 We Are Happy，则经过替换之后的字符串为 We%20Are%20Happy
 *
 */
public class Task2
{
	/**
	 * toString() 和 String.valueOf() 的区别：
	 * 调用 toString() 方法的对象不能为 null，否则会 空指针异常
	 * String.valueOf() 方法也是调用 toString() 但是在调用前会判断是否为 null
	 * 如果不为 null，则正常调用 toString()
	 * 如果为 null，则返回字符串形式的 null
	 */
	public String replace1(StringBuffer text)
	{
		return text.toString().replace(" ", "%20");
	}

	public String replace2(StringBuffer str)
	{
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < str.toString().length(); i ++)
		{
			char b = str.charAt(i);
			if(String.valueOf(b).equals(" "))
				s.append("%20");
			else
				s.append(b);
		}
		return sb.toString();
	}
}