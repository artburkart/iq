class ReverseString:
    def __init__(self):
        pass

    @staticmethod
    def reverse_string(string):
        """Returns the reverse of a given string
        Since the `str` object is immutable, I can't just index on it and
        return it reversed, I have to make a separate list

        Keyword arguments:
        string -- str to reverse
        """
        if not isinstance(string, str):
            raise AttributeError()

        string = list(string)
        length = len(string)
        for i in range(0, length / 2):
            end = length - 1 - i
            temp = string[i]
            string[i] = string[end]
            string[end] = temp
        return ''.join(string)
