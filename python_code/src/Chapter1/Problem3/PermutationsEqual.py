from collections import Counter


class PermutationsEqual:
    def __init__(self):
        pass

    @staticmethod
    def permutations_equal(str_a, str_b):
        """Checks that two strings are permutations of each other

        Keyword arguments:
        str_a -- first input str
        str_b -- second input str
        """
        if not isinstance(str_a, str) or not isinstance(str_b, str):
            raise AttributeError("inputs must be valid str")
        if len(str_a) != len(str_b):
            return False

        return Counter(str_a) == Counter(str_b)
