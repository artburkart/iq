from collections import defaultdict


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

        tracker = defaultdict(int)

        for s in str_a:
            tracker[s] += 1
        for s in str_b:
            if tracker.get(s) is None or tracker.get(s) == 0:
                return False
            tracker[s] -= 1

        return sum(tracker.values()) == 0
