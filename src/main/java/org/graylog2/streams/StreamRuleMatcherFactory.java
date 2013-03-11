/**
 * Copyright 2011 Lennart Koopmann <lennart@socketfeed.com>
 *
 * This file is part of Graylog2.
 *
 * Graylog2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog2.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.graylog2.streams;

import org.graylog2.streams.matchers.*;

/**
 * @author Lennart Koopmann <lennart@socketfeed.com>
 */
public class StreamRuleMatcherFactory {

    public static StreamRuleMatcher build(int ruleType) throws InvalidStreamRuleTypeException {
        StreamRuleMatcher matcher = null;

        switch (ruleType) {
            case StreamRuleImpl.TYPE_EXACT:
                matcher = new ExactMatcher();
                break;
            case StreamRuleImpl.TYPE_REGEX:
                matcher = new RegexMatcher();
                break;
            case StreamRuleImpl.TYPE_GREATER:
                matcher = new GreaterMatcher();
                break;
            case StreamRuleImpl.TYPE_SMALLER:
                matcher = new SmallerMatcher();
                break;
            default:
                throw new InvalidStreamRuleTypeException();
        }

        return matcher;
    }

}