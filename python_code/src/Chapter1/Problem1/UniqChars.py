class UniqChars:
    """Provides different algorithms for checking no redundancy
    exists in a given String
    """
    def __init__(self):
        """Initializes the UniqChars class
        """
        pass

    def __assert_not_none(self, obj, expected):
        """Asserts an object not be None.

        Keyword arguments:
        obj -- the object to check for nullness
        expected -- the expected type of object
        """
        if obj is None:
            raise AttributeError(
                "Given input, {}, must not be null".format(expected))

    def __method1(self, string):
        """Sorts string, then
        returns True if redundant chars present, otherwise False

        O(nlogn) sorts array with dual-pivot quicksort

        Keyword arguments:
        string -- str to check for redundancy of chars
        """
        self.__assert_not_none(string, str)
        if (len(string) == 0):
            return False
        if (len(string) == 1):
            return True

        sorted_string = sorted(string)
        for i in range(len(sorted_string) - 1):
            if sorted_string[i] == sorted_string[i + 1]:
                return False
        return True

    def __method2(self, string):
        """Creates boolean mask, then
        returns True if redundant chars present, otherwise False

        O(n) iterates through chars twice

        Keyword arguments:
        string -- str to check for redundancy of chars
        """
        self.__assert_not_none(string, str)
        if (len(string) == 0):
            return False
        if (len(string) == 1):
            return True

        max_val = ord(max(string))
        boolean = [False for i in range(max_val + 1)]
        for c in string:
            if boolean[ord(c)]:
                return False
            boolean[ord(c)] = True
        return True

    def __method3(self, string):
        """Creates binary mask, then
        returns True if redundant chars present, otherwise False

        O(n) iterates through chars once

        Keyword arguments:
        string -- str to check for redundancy of chars
        """
        self.__assert_not_none(string, str)
        if (len(string) == 0):
            return False
        if (len(string) == 1):
            return True

        mask = 0
        for c in string:
            marker = 1 << ord(c)
            if (marker & mask > 0):
                return False
            mask |= marker
        return True

    @staticmethod
    def uniqChars(string, method):
        """Selects algorithm to determine redundancy of chars in given string

        Keyword arguments:
        string -- str to check for redundancy of chars
        method -- algorithm to use on string
        """
        UniqChars.__assert_not_none(UniqChars(), method, int)
        selected = UniqChars.__METHODS.get(method)
        if not selected:
            raise AttributeError("Invalid method input: '{}'".format(method))
        return UniqChars.__METHODS[method](UniqChars(), string)

    SORTED = 1
    BOOL = 2
    BIT = 3

    __METHODS = {
        1: __method1,
        2: __method2,
        3: __method3
    }
